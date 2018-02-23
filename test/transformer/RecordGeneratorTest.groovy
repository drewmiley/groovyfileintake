package transformer

class RecordGeneratorTest extends GroovyTestCase {

    private RecordGenerator recordGenerator

    void setUp() {
        recordGenerator = new RecordGenerator()
    }

    void tearDown() {
        recordGenerator = null
    }

    void testNewRecord() {
        assert recordGenerator.newRecord() == 'Some Text'
    }
}
