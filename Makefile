# 'make' needs to be installed.
#
# Type make to run it.

# This is the path to your src directory.
# Example: java/src
SRC_DIR=./src/


# This is the path to the rpnpackage
PACK_DIR=./src/rpnpackage/

# this is the path for the class files
OUT_DIR=./out/

# This is the path to your JUnit jars and such.
JUNIT_DIR=./libs/

# This is the path to your test directory.
# Example: java/test
TEST_DIR=./test/

# Make sure absolute paths are used.
# Generally, it doesn't work if ~/ is used and neither does a *.
CLASS_PATH_COMPILE=.:$(JUNIT_DIR)junit-4.12.jar:$(JUNIT_DIR)hamcrest-core-1.3.jar:$(JUNIT_DIR)mockito-core-1.10.19.jar:$(JUNIT_DIR)objenesis-2.4.jar

# The classpath to run.
# Make sure the source directory and test directory are on the path.
CLASS_PATH_RUN=$(JUNIT_DIR)hamcrest-core-1.3.jar:$(CLASS_PATH_COMPILE):$(SRC_DIR):$(TEST_DIR)

# This is the path for the junit test runner.
#
# Would need to add the runner to COMPILE_TARGETS
# if you're wanting to use your own.
RUNNER=org.junit.runner.JUnitCore

# ADD NEW FILES to compile here.
COMPILE_TARGETS= $(PACK_DIR)SymbolTable.java $(TEST_DIR)SymbolTableTests.java

# Testing targets.
# Their directory will be on the Class Path.
TEST_TARGETS= SymbolTableTests


run: build
	java -cp $(CLASS_PATH_RUN) $(RUNNER) $(TEST_TARGETS) || true

build:
	javac -cp $(CLASS_PATH_COMPILE) $(COMPILE_TARGETS)

style:
	java -jar $(JUNIT_DIR)checkstyle-7.0-all.jar -c ./google_checks_modified.xml $(SRC_DIR)*.java

buildp:
	javac -sourcepath $(SRC_DIR) -d $(OUT_DIR) $(SRC_DIR)RPN.java

rpn: buildp
	java -cp $(OUT_DIR) RPN
