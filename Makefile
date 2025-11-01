include Makefile.git

ANTLR_PATH = $(shell find /usr/local/lib -name "antlr-*-complete.jar")

# If you want to use Maven to manage all dependencies, uncomment the following line
# LLVM_CLASSPATH = $(shell mvn dependency:build-classpath -q -Dmdep.outputFile=/dev/stdout)
LLVM_CLASSPATH = /usr/local/lib/antlr-4.9.1-complete.jar:/usr/local/lib/javacpp-1.5.7-linux-x86_64.jar:/usr/local/lib/javacpp-1.5.7.jar:/usr/local/lib/javacpp-platform-1.5.7.jar:/usr/local/lib/llvm-13.0.1-1.5.7-linux-x86_64.jar:/usr/local/lib/llvm-13.0.1-1.5.7.jar:/usr/local/lib/llvm-platform-13.0.1-1.5.7.jar

export CLASSPATH=$(ANTLR_PATH):$(LLVM_CLASSPATH)

FILEPATH = tests/test1.sysy
IRPATH = tests/test1.ll

DOMAINNAME = oj.compilers.cpl.icu
ANTLR = java -jar $(ANTLR_PATH) -listener -visitor -long-messages
JAVAC = javac -g
JAVA = java

PFILE = $(shell find . -name "SysYParser.g4")
LFILE = $(shell find . -name "SysYLexer.g4")
JAVAFILE = $(shell find . -name "*.java")

compile: antlr
	$(call git_commit,"make")
	mkdir -p classes
	$(JAVAC) -classpath $(CLASSPATH) $(JAVAFILE) -d classes

run: compile
	java -classpath ./classes:$(CLASSPATH) Main $(FILEPATH) $(IRPATH)

antlr: $(LFILE) $(PFILE)
	$(ANTLR) $(PFILE) $(LFILE)

test: compile
	$(call git_commit, "test")
	if [ -e nohup.out ]; then rm nohup.out; fi
	nohup java -classpath ./classes:$(CLASSPATH) Main ./tests/test1.sysy ./tests/test1.ll &

clean:
	rm -f src/*.tokens
	rm -f src/*.interp
	rm -f src/SysYLexer.java src/SysYParser.java src/SysYParserBaseListener.java src/SysYParserBaseVisitor.java src/SysYParserListener.java src/SysYParserVisitor.java
	rm -rf classes
	rm -rf out

submit: clean
	git gc
	bash submit.sh

.PHONY: compile antlr test run clean submit
