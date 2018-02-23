package transformer

class FizzbuzzRunner {

    final def fizzbuzzConverter = { int x = 3, int y = 5, int i, String fizz = 'Fizz', String buzz = 'Buzz' ->
        def fizzbuzzString = ''
            if (i % x == 0) fizzbuzzString += fizz
            if (i % y == 0) fizzbuzzString += buzz
        fizzbuzzString ?: i
    }

    def converter = fizzbuzzConverter

    private def range = (1..15)

    FizzbuzzRunner() {}

    FizzbuzzRunner(int highestValue) {
        this.setHighestValue(highestValue)
    }

    FizzbuzzRunner(int x, int y, int highestValue) {
        this.setHighestValue(highestValue)
        this.converter = fizzbuzzConverter.curry(x, y)
    }

    FizzbuzzRunner(int highestValue, String fizz, String buzz) {
        this.setHighestValue(highestValue)
        this.converter = fizzbuzzConverter.rcurry(fizz, buzz)
    }

    FizzbuzzRunner(int x, int y, int highestValue, String fizz, String buzz) {
        this.setHighestValue(highestValue)
        this.converter = fizzbuzzConverter.curry(x, y).rcurry(fizz, buzz)
    }

    def setHighestValue(int highestValue) {
        this.range = (1..highestValue)
    }

    def run() {
        range.collect { converter(it) }
    }

}

def fizzbuzz = new FizzbuzzRunner(2, 7, 25, 'you', 'rang')

fizzbuzz.run().each {
    println it
}