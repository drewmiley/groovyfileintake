package transformer

class TextGeneratorTest extends GroovyTestCase {

    private TextGenerator textGenerator

    void tearDown() {
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
}
