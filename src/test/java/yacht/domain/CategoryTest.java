package yacht.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CategoryTest {

    @Test
    void 카테고리는_이름을_가진다() {
        // when & then
        assertThat(Category.ONES.getName()).isEqualTo("Ones");
        assertThat(Category.TWOS.getName()).isEqualTo("Twos");
        assertThat(Category.THREES.getName()).isEqualTo("Threes");
        assertThat(Category.CHOICE.getName()).isEqualTo("Choice");
    }
}
