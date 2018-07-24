package at.aau.softwaredynamics.diffws;

import at.aau.softwaredynamics.diffws.domain.DiffResult;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class DiffMatchPatch {
    private final String src;
    private final String dst;

    List<String> original;
    List<String> revised;

    public DiffMatchPatch(String src, String dst) {
        super(src, dst);
        this.src = src;
        this.dst = dst;
        original = stringToLines(src);
        revised = stringToLines(dst);
    }

    public void loadFromFile(String srcFile, String dstFile) {
        original = fileToLines(srcFile);
        revised = fileToLines(dstFile);
    }

    public static List<String> fileToLines(String fileName) {
        ArrayList<String> liste = new ArrayList<>();

        Path path = Paths.get(fileName);
        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(liste::add);
        }  catch (IOException ex) {
            System.out.println("Can not Read File: " + fileName);
        }
        return liste;
    }

    public static List<String> stringToLines(String source) {
        return Arrays.asList(source.split("(\r?\n)"));
    }


    @Override
    public DiffResult diff() {
        //TODO implement!
        return null;
    }

}
