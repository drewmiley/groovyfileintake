package transformer

import java.util.stream.Collectors

class TextGenerator {

    final String directory

    final String fileName

    TextGenerator(String fileRoot) {
        String[] splitName = fileRoot.split('/')
        directory = Arrays.stream(Arrays.copyOf(splitName, splitName.length - 1))
            .collect(Collectors.joining('/'))
        fileName = splitName[splitName.length - 1]
    }

    void generateFile() {
        System.out.println(directory)
        System.out.println(fileName)
    }
}
