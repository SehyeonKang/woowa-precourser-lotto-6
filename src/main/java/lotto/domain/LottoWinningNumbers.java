package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoWinningNumbers {

    private final List<Integer> numbers;

    public LottoWinningNumbers(List<Integer> numbers) {
        validateNumbersCount(numbers);
        validateNumberRange(numbers);
        validateDuplicateNumbers(numbers);
        this.numbers = new ArrayList<>();
        addNumbers(numbers);
    }

    private void validateNumbersCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호를 6개 적어주세요.");
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호의 숫자 범위는 1부터 45까지입니다.");
            }
        }
    }

    private void validateDuplicateNumbers(List<Integer> numbers) {
        long distinctCount = numbers.stream()
                .distinct()
                .count();

        if (distinctCount != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 번호가 있습니다.");
        }
    }

    private void addNumbers(List<Integer> numbers) {
        this.numbers.addAll(numbers);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
