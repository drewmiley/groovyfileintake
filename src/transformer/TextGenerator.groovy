package transformer

class TextGenerator {

    final String directory

    final String fileName

    TextGenerator(String fileRoot) {
        directory = fileRoot
        fileName = fileRoot
    }

    void generateFile() {
        System.out.println(directory)
        System.out.println(fileName)
    }
}
