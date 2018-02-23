package transformer

class FileWriter {

    private String directory

    private String fileName

    private String textToWrite

    FileWriter(String directory, String fileName, String textToWrite) {
        this.directory = directory
        this.fileName = fileName
        this.textToWrite = textToWrite
    }

    void write() {
        def folder = new File(directory)

        if (!folder.exists() ) {
            folder.mkdirs()
        }

        new File( folder, fileName ).withWriterAppend { text -> text << textToWrite }
    }
}
