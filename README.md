# Define4Me
A graphical Java application that finds and outputs the definitions of a given
list of words pasted into it (each line will be considered a new word, to allow
searching for multi-worded phrases such as "deep web"). It uses the MVC design
pattern through the Swing GUI library. The definitions are obtained through
meetDeveloper's [free dictionary API] and parsed with the [Jackson JSON
library].

## Building from source
After installing a [JDK] version 17 or higher, you may download the source code,
`cd` into it with your desired terminal application and run
`gradlew build --no-daemon` (on macOS you may need to run `chmod +x gradlew`
first, and the `--no-deamon` option can be omitted if you would like to keep the gradle
daemon in memory, which makes future gradle builds quicker.).

Once finished, the resulting files will be in the ```build``` folder. The .jar
will be in `build/libs` and gradle's default run scripts will be in `build/bin`.

## License
Define4Me is licensed under the GPLv3, for more information please read the
[LICENSE file] in the repository root.

[free dictionary API]: https://github.com/meetDeveloper/freeDictionaryAPI
[Jackson JSON library]: https://github.com/FasterXML/jackson
[JDK]: https://adoptium.net/
[LICENSE file]: https://github.com/marcelohdez/define4me
