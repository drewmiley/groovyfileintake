package transformer

class TextGeneratorTest extends GroovyTestCase {

    private TextGenerator textGenerator

    void setUp() {
        textGenerator = new TextGenerator('resources/file1')
    }

    void tearDown() {
        textGenerator = null
    }
}
