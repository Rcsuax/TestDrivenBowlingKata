
import spock.lang.Specification

class GameSpec extends Specification {

	Game g

	def setup() {
		g = new Game()
	}

	def "Test gutterball game"() {
		when:
			rollMany(20,0)
		then:
			g.score() == 0
	}

	def "Test all ones"() {
		when:
			rollMany(20,1)
		then:
			g.score() == 20
	}

	def "Test one spare"() {
		when:
			rollSpare()
			g.roll(3)
			rollMany(17,0)
		then:
			g.score() == 16
	}

	def "Test one strike"() {
		when:
			g.with {
				rollStrike()
				roll(3)
				roll(4)
				rollMany(16, 0)
			}
		then:
			g.score() == 24

	}

	def "Test perfect game"(){
		when:
			rollMany(12,10)
		then:
			g.score() == 300
	}

	private void rollStrike() {
		g.roll(10)
	}

	private void rollSpare() {
		g.with {
			roll(5)
			roll(5)
		}
	}

	private void rollMany(n, pins){
		n.times {
			g.roll(pins)
		}
	}
}