package transformer

import java.util.stream.Collectors

class TextGenerator {

    final String directory

    final String fileName

    final RecordGenerator recordGenerator

    final int numberOfRecords

    TextGenerator(String fileRoot, RecordGenerator recordGenerator = new RecordGenerator(), int numberOfRecords = 100) {
        String[] splitName = fileRoot.split('/')
        this.directory = Arrays.stream(Arrays.copyOf(splitName, splitName.length - 1))
            .collect(Collectors.joining('/'))
        this.fileName = splitName[splitName.length - 1]
        this.recordGenerator = recordGenerator
        this.numberOfRecords = numberOfRecords
    }

    String generatedRecord(int i) {
        recordGenerator.newRecord(i)
    }

    String generatedText() {
        String generatedText = ''
        (1..numberOfRecords).eachWithIndex { d, i -> generatedText += "${ generatedRecord(i) }\n" }
        generatedText
    }

    void generateFile() {
        FileWriter fileWriter = new FileWriter(directory, fileName, generatedText())
        fileWriter.write()
    }
}
