#!/bin/bash

# Define the base directory (current directory)
BASE_DIR=$(pwd)

# Create the necessary directories
mkdir -p $BASE_DIR/src/main/java/com/example
mkdir -p $BASE_DIR/src/main/resources
mkdir -p $BASE_DIR/src/test/java/com/example
mkdir -p $BASE_DIR/src/test/resources

# Move Java source files to the appropriate directory
# Adjust the source path if your Java files are located elsewhere
if [ -d "$BASE_DIR/src" ]; then
  mv $BASE_DIR/src/*.java $BASE_DIR/src/main/java/com/example/
fi

# Move resource files to the appropriate directory
# Adjust the source path if your resource files are located elsewhere
if [ -d "$BASE_DIR/resources" ]; then
  mv $BASE_DIR/resources/* $BASE_DIR/src/main/resources/
fi

# Move test Java files to the appropriate directory
# Adjust the source path if your test files are located elsewhere
if [ -d "$BASE_DIR/test" ]; then
  mv $BASE_DIR/test/*.java $BASE_DIR/src/test/java/com/example/
fi

# Move test resource files to the appropriate directory
# Adjust the source path if your test resource files are located elsewhere
if [ -d "$BASE_DIR/test-resources" ]; then
  mv $BASE_DIR/test-resources/* $BASE_DIR/src/test/resources/
fi

# Ensure the Maven wrapper scripts are in place
if [ ! -f "$BASE_DIR/mvnw" ]; then
  curl -o $BASE_DIR/mvnw https://raw.githubusercontent.com/takari/maven-wrapper/master/mvnw
  chmod +x $BASE_DIR/mvnw
fi

if [ ! -f "$BASE_DIR/mvnw.cmd" ]; then
  curl -o $BASE_DIR/mvnw.cmd https://raw.githubusercontent.com/takari/maven-wrapper/master/mvnw.cmd
fi

# Ensure the .gitignore file is in place
if [ ! -f "$BASE_DIR/.gitignore" ]; then
  echo -e "target/\n*.log\n*.tmp\n" > $BASE_DIR/.gitignore
fi

# Ensure the README.md file is in place
if [ ! -f "$BASE_DIR/README.md" ]; then
  echo "# My Spring Boot Project" > $BASE_DIR/README.md
fi

echo "Project reconfiguration complete."