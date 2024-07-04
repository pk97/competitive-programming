package daily.challenge.pratice;

import java.util.ArrayList;
import java.util.List;

public class FlatMapUseCase {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();

        List<Integer> collect = list.stream()
                    .flatMap(x -> x.stream())
                    .toList();
    }
}
