# Abstract Syntax Tree Interpreter (Rinha)

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white) ![Rust](https://img.shields.io/badge/rust-%23000000.svg?style=for-the-badge&logo=rust&logoColor=white) ![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)

### Project Status: in development

This is a Java-based interpreter project, developed as part of a challenge aimed at creating an interpreter or compiler capable of running on a machine with limited resources (2 cores and 2 GB of RAM). The primary goal of this interpreter is to process an "abstract syntax tree" stored in JSON format and execute the program based on the information provided in this abstract tree.

## Project Context

The challenge proposes the following workflow:

1. Install Rust.
2. Install the "rinha" tool using Cargo.
3. Add the `.cargo/bin` directory to your PATH.
4. Generate an abstract syntax tree from a source file "source.rinha" using the command `rinha source.rinha > source.rinha.json`.
5. Use the generated JSON as input for this Java interpreter.

## Used Stacks

This project utilizes the following technologies:

- **Java**: The primary programming language for developing the interpreter.
- **Docker**: Docker is used to create an isolated execution environment for the interpreter.
- **Rust**: The Rust programming language is used to generate the abstract syntax tree using the "rinha" tool.

## How to Run

To execute the abstract syntax tree interpreter, follow these steps:

1. Ensure you have Docker installed on your machine. If you don't have Docker installed, you can get it at [https://www.docker.com/get-started](https://www.docker.com/get-started).

2. Clone this repository to your local machine.

3. Navigate to the project directory:

   ```bash
   cd rinha
   ```

4. Build the Docker image using the provided Dockerfile:
      ```bash
   docker build -t interpretador-arvore-sintatica .
   ```
5. Now, you can run the interpreter with the JSON generated from the abstract syntax tree.

   ```bash
   docker run rinha
   ```
## Contributions

Contributions are welcome! Feel free to open issues and pull requests to improve this project.


**Enjoy using the abstract syntax tree interpreter and good luck with the challenge!**

## Author

This project was created by Gustavo Costa.