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

    @Test
    void 자동차는_처음에_0의_위치에_있다() {
        //given
        Car car = new Car("pobi");

        //when
        int position = car.getPosition();

        //then
        assertThat(position).isEqualTo(0);
    }
}
