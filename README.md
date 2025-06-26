# Glossary KWIC with ADT

As part of the Fundamentals of Programming knowledge development for my Master's degree in Computer Science I developed a Java-based Maven project that generates a KWIC (Key Word In Context) glossary from PDF documents or keyword lists. The project is designed using a modular architecture with *Abstract Data Types* to handle input, keyword generation, indexing, alphabetization, and output formatting.

## Features

- **Flexible Input**: Read text and keywords from PDF files or plain text files.
- **Keyword Generation**: Automatically extract keywords from PDFs, filtering out articles, prepositions, and conjunctions.
- **Page Indexing**: Find and record the pages where each keyword appears, including support for AND-combined keywords.
- **Alphabetization**: Sort keywords case-insensitively.
- **Plain Text Output**: Export a neatly formatted glossary to a `.txt` file.

## Prerequisites

- Java 1.7 or higher
- Maven 3.x

## Getting Started

1. **Clone the repository**

   ```bash
   git clone https://github.com/yourusername/GlossaryKWIC_ADT.git
   cd GlossaryKWIC_ADT
   ```

2. **Build with Maven**

   ```bash
   mvn clean package
   ```

3. **Run the application**

   ```bash
   # From project root, using example PDF name and keyword file name (without extensions)
   java -cp target/glossarykwic_adt-1.jar com.glossarykwic_adt.App Document2 keywords
   ```

   - `Document2` refers to `src/main/java/com/glossarykwic_adt/persistence/Document2.pdf`.
   - `keywords` refers to `src/main/java/com/glossarykwic_adt/persistence/keywords.txt`.

4. **Review output**

   - The generated glossary is written to `src/main/java/com/glossarykwic_adt/persistence/output_glossary.txt` (or `[output]_glossary.txt`).

## Directory Structure

```
GlossaryKWIC_ADT/
├── pom.xml
├── README.md       
└── src/
    ├── main/
    │   └── java/
    │       └── com/glossarykwic_adt/
    │           ├── App.java
    │           ├── MasterControl.java
    │           ├── Modules/
    │           │   ├── IModule.java
    │           │   ├── InputModule.java
    │           │   ├── WordsFinderModule.java
    │           │   ├── AlphabetizerModule.java
    │           │   └── OutputModule.java
    │           │   ├── InputImpl/      ← PDF and file input strategies
    │           │   ├── KWgenImpl/      ← Keyword generation strategies
    │           │   └── OutputImpl/     ← Glossary output strategies
    │           └── persistence/
    │               ├── keywords.txt
    │               └── output_glossary.txt
    └── test/
        └── java/com/glossarykwic_adt/AppTest.java
```

## Architecture

```mermaid
classDiagram

    class MasterControl{
        -modules : ArrayList~IModule~
        -getModuleByName(String name) IModule
        +addModule(IModule module) void
        +run() void
        -orderModules() void
    }

    class IModule{
        <<abstract>>
        #text : LinkedHashMap~Integer-String~
        #keywords : LinkedHashMap~String-Set~Integer~~
        #name : String
        +IModule(String name)
        +run(IModule module)* void
        +getText() LinkedHashMap~Integer-String~
        +getkeywords() LinkedHashMap~String-Set~Integer~~ 
        +getName() String
    }
    class InputModule{
        -inputStrategy : InputStrategy
        -documentName : String
        -kwFileName : String
        +run(IModule module) void
        -run() void
        -readInput() void
    }

    
    class WordsFinderModule{
        +run(IModule module) void
        -getPages(String keyword, LinkedHashMap~Integer-String~ text)
    }

    class AlphabetizerModule{
        +run(IModule module) void
        -alphabetize(LinkedHashMap~String-Set~Integer~~ keywords) void
    }

    class OutputModule{
        -outputFileName : String
        -outputStrategy : OutputStrategy
        +run(IModule module) void
        -write(String filename, LinkedHashMap~String-Set~Integer~~ keywords) void
    }


    class InputStrategy{
        <<interface>>
        +read(String filename)* LinkedHashMap~Integer-String~

    }

    class InputFromPDF{
        +read(String filename) LinkedHashMap~Integer-String~
    }

    
    class OutputStrategy{
        <<interface>>
        +write(String filename, LinkedHashMap~String-Set~Integer~~ keywords )* void
    }
    class OutputToTXT{
        -lineLenght : int
        +write(String filename, LinkedHashMap~String-Set~Integer~~ keywords ) void
        -lineFormater(String keyword, Set~Integer~ pages)
    }

    class KWgenStrategy{
        +read(String filename)* LinkedHashMap~String-Set~Integer~~
    }
    class KWgenFromPDF{
        -articulos : String[]
        -preposiciones : String[]
        -conjunciones : String[]
        +read(String filename) LinkedHashMap~String-Set~Integer~~
        -textCleaner(String text) String
        -keywordsMaker(String text) LinkedHashMap~String-Set~Integer~~
    }

    class KWgenFromFile{
        +read(String filename) LinkedHashMap~String-Set~Integer~~
    }

    class App{
        +main(String[] args)$ void
    }

    App -- MasterControl
    MasterControl *-- IModule
    
    IModule <|-- InputModule
    IModule <|-- AlphabetizerModule
    IModule <|-- WordsFinderModule
    IModule <|-- OutputModule
    

    OutputStrategy <|.. OutputToTXT
    InputStrategy <|.. InputFromPDF

    KWgenStrategy <|.. KWgenFromPDF
    KWgenStrategy <|.. KWgenFromFile

    OutputModule *-- OutputStrategy
    InputModule *-- InputStrategy

    InputModule<.. KWgenStrategy


```

## Modules Overview

1. **InputModule** (`Modules/InputModule.java`)

   - Reads raw text pages via `InputStrategy` (PDF or file).
   - Generates initial keyword map via `KWgenStrategy` (from PDF or text file).

2. **WordsFinderModule** (`Modules/WordsFinderModule.java`)

   - Scans each page for keyword occurrences.
   - Supports single keywords and `"A AND B"` style queries.

3. **AlphabetizerModule** (`Modules/AlphabetizerModule.java`)

   - Sorts the keyword map alphabetically (case-insensitive).

4. **OutputModule** (`Modules/OutputModule.java`)

   - Writes the sorted glossary to a text file with page indices.

## Customization

- **Stop words** (articles, prepositions, conjunctions) in `KWgenFromPDF` can be modified in arrays.
- **Line length** for output formatting in `OutputToTXT` (`lineLength` field).

## Running Tests

Execute unit tests with:

```bash
mvn test
```

## Dependencies

- Apache PDFBox 2.0.27 (PDF text extraction)
- JUnit 4.11 (testing)

