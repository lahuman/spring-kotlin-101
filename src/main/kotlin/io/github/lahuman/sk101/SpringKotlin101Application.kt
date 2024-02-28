package io.github.lahuman.sk101

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@EnableJpaAuditing
@SpringBootApplication
class SpringKotlin101Application

fun main(args: Array<String>) {
	runApplication<SpringKotlin101Application>(*args)
}
