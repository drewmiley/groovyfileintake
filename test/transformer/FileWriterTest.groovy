package transformer

class FileWriterTest extends GroovyTestCase {

    private String directory = 'resources'

    private String fileName = 'write.txt'

    private String textToWrite = 'qwerty'

    private FileWriter fileWriter

    void setUp() {
        fileWriter = new FileWriter(directory, fileName, textToWrite)
    }

    void tearDown() {
        def file = new File("${ directory }/${ fileName }")
        file.delete()
        fileWriter = null
    }

    void testCreatesFile() {
        fileWriter.write()

        def file = new File("${ directory }/${ fileName }")
        assert file.exists()
    }

    void testFileText() {
        fileWriter.write()

        def file = new File("${ directory }/${ fileName }")
        assert file.getText() == textToWrite
    }
}
