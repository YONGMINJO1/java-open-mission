package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    void 자동차를_여러대를_생성할_수_있다() {
        //given
        List<String> names = List.of("pobi", "woni", "jun");

        //when
        Cars cars = new Cars(names);

        //then
        assertThat(cars.getCars()).hasSize(3);
    }

    @Test
    void 모든_자동차가_전진할_수_있다() {
        //given
        Cars cars = new Cars(List.of("pobi", "woni", "jun"));

        //when
        cars.moveAll();

        //then
        List<Car> carList = cars.getCars();
        //랜덤이므로 위치가 0 이상인지 확인
        assertThat(carList).allMatch(car -> car.getPosition() >= 0);
    }
}
