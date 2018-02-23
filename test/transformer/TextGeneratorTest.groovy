package transformer

class TextGeneratorTest extends GroovyTestCase {

    private String filePath

    private TextGenerator textGenerator

    void setUp() {
        filePath = 'resources/generated.txt'
        textGenerator = new TextGenerator(filePath)
    }

    void tearDown() {
        def file = new File(filePath)
        file.delete()
        textGenerator = null
    }

    void testConstructorSetsDirectory() {
        textGenerator = new TextGenerator('A')
        assert !textGenerator.getDirectory()

        textGenerator = new TextGenerator('A/B')
        assert textGenerator.getDirectory() == 'A'

        textGenerator = new TextGenerator('A/B/C')
        assert textGenerator.getDirectory() == 'A/B'

        textGenerator = new TextGenerator('A/B/C/D')
        assert textGenerator.getDirectory() == 'A/B/C'
    }

    void testConstructorSetsFileName() {
        textGenerator = new TextGenerator('A')
        assert textGenerator.getFileName() == 'A'

        textGenerator = new TextGenerator('A/B')
        assert textGenerator.getFileName() == 'B'

        textGenerator = new TextGenerator('A/B/C')
        assert textGenerator.getFileName() == 'C'

        textGenerator = new TextGenerator('A/B/C/D')
        assert textGenerator.getFileName() == 'D'
    }

    void testGeneratedText() {
        String generatedText = ''
        (1..100).each { generatedText += 'Some Text\n' }
        assert textGenerator.generatedText() == generatedText
    }

    void testFileIsGenerated() {
        textGenerator.generateFile()

        def file = new File(filePath)
        assert file.exists()
    }

    void testFileIsGeneratedWithCorrectText() {
        textGenerator.generateFile()

        def file = new File(filePath)
        String generatedText = ''
        (1..100).each { generatedText += 'Some Text\n' }
        assert file.getText() == generatedText
    }
}
