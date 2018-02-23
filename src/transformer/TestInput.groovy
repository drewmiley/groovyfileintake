package transformer

import java.nio.file.Files
import java.nio.file.Paths
import java.util.stream.Stream

String fileName = "./lines.txt"

try {
    Stream<String> stream = Files.lines(Paths.get(fileName))
    stream.forEach( { line -> System.out.println(line) } )
} catch (IOException e) {
    e.printStackTrace()
}
