import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import nu.studer.gradle.jooq.JooqEdition
import org.jooq.meta.jaxb.ForcedType
import org.jooq.meta.jaxb.Logging
import org.jooq.meta.jaxb.Property

plugins {
	id("org.springframework.boot") version "3.2.2"
	id("io.spring.dependency-management") version "1.1.4"
	id("nu.studer.jooq") version "9.0"
	kotlin("jvm") version "1.9.22"
	kotlin("plugin.spring") version "1.9.22"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_21
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-jooq")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	runtimeOnly("com.mysql:mysql-connector-j")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	testImplementation("org.springframework.boot:spring-boot-starter-test")

	jooqGenerator("com.mysql:mysql-connector-j")
}

jooq {
	version.set("3.19.1")
	edition.set(nu.studer.gradle.jooq.JooqEdition.OSS)
	configurations {
		create("main") {
			jooqConfiguration.apply {
				jdbc.apply {
					driver = "com.mysql.cj.jdbc.Driver"
					url = "jdbc:mysql://db:3306/book_manage?autoReconnect=true&allowPublicKeyRetrieval=true&useSSL=false&maxReconnects=5"
					user = "root"
					password = "mysql"
				}
				generator.apply {
					name = "org.jooq.codegen.DefaultGenerator"
					database.apply {
						name = "org.jooq.meta.mysql.MySQLDatabase"
						inputSchema = "book_manage"
					}
					generate.apply {
						isDeprecated = false
						isTables = true
						isImmutablePojos = true
						isFluentSetters = true
					}
					target.apply {
						packageName = "com.example.demo"
						directory = "src/generated/jooq"
					}
					strategy.name = "org.jooq.codegen.DefaultGeneratorStrategy"
				}
			}
		}
	}
}

tasks.bootRun {

	jvmArgs("-Dspring.profiles.active=develop")
	jvmArgs("-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005")

}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "21"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
