package transformer

import java.util.stream.Collectors

class TextGenerator {

    final String directory

    final String fileName

    final int numberOfRecords

    TextGenerator(String fileRoot, int numberOfRecords = 100) {
        String[] splitName = fileRoot.split('/')
        this.directory = Arrays.stream(Arrays.copyOf(splitName, splitName.length - 1))
            .collect(Collectors.joining('/'))
        this.fileName = splitName[splitName.length - 1]
        this.numberOfRecords = numberOfRecords
    }

    String generatedRecord() {
        'Some Text'
    }

    String generatedText() {
        String generatedText = ''
        (1..numberOfRecords).each { generatedText += "${ generatedRecord() }\n" }
        generatedText
    }

    void generateFile() {
        def folder = new File(directory)

        if (!folder.exists() ) {
            folder.mkdirs()
        }

        new File( folder, fileName ).withWriterAppend { text -> text << generatedText() }
    }
}
