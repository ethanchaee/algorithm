package com.ethanchae.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42746?language=java
 * <p>
 * 0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
 * <p>
 * 예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.
 * <p>
 * 0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.
 * <p>
 * 제한 사항
 * numbers의 길이는 1 이상 100,000 이하입니다.
 * numbers의 원소는 0 이상 1,000 이하입니다.
 * 정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
 * <p>
 * 1: 20 고민함
 * 다른 분의 문제 풀이 아이디어 참고
 * https://codevang.tistory.com/294
 * <p>
 * - 두 문자열을 합쳐 본 후, 더 크게 나오는 숫자를 return
 * <p>
 * 따라서 이 문제는 정렬 기준을 잡을 때 두 숫자를 앞 뒤로 직접 붙여보고 판단하는 수밖에 없을 것 같습니다.
 * 남는 자릿수에 일정 숫자를 채워넣는다거나 하는 방식으로 다른 기준을 몇 번 시도해봤는데 다 안되네요. ㅎㅎ
 * a.compareTo(b)
 *
 * - 앞에서부터 비교하다 다른 문자열이 나오면 'a-b' 순서로 해당 문자의 아스키코드 값을 뺀 결과(int)를 리턴
 * 위 메소드에서 a, b 순서로 있을 때 (b+a).compareTo(a+b) 을 했을 경우 'b+a'가 더 크다면 자리를 바꿔주면 되므로 아래와 같이 작성해주면 됩니다.
 */
public class TheMaximumNumber {


    int zeroCount = 0;

    public String solution(int[] numbers) {
        List<String> numberList = parsingNumberList(numbers);
        StringBuilder builder = new StringBuilder();
        for (String number : numberList) {
            builder.append(number);
        }
        for (int i = 0; i < zeroCount; i++) {
            if (builder.length() == 0) return "0";
            builder.append(0);
        }
        return builder.toString();
    }

    private ArrayList parsingNumberList(int[] numbers) {
        ArrayList<String> list = new ArrayList();
        for (int number : numbers) {
            if (number == 0) {
                zeroCount++;
                continue;
            }
            list.add(String.valueOf(number));
        }
        list.sort((o1, o2) -> ((o2 + o1).compareTo(o1 + o2)));
        return list;
    }
}
