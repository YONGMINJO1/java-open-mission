package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void 자동차는_이름을_가진다() {
        //given
        String name = "pobi";

        //when
        Car car = new Car(name);

        //then
        assertThat(car.getName()).isEqualTo("pobi");
    }

}
