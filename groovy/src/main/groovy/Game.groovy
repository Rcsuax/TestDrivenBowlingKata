class Game {

	private def rolls = new int[21]
	private def currentRolls = 0

	void roll(int pins){
		rolls[currentRolls++] = pins
	}

	def score(){
		def score = 0
		def frameIndex = 0
		10.times {
			if(isStrike(frameIndex)){
				score+= 10 + strikeBonus(frameIndex)
				frameIndex++
			}
			else if(isSpare(frameIndex)){
				score+= 10 + spareBonus(frameIndex)
				frameIndex += 2
			}
			else {
				score+= sumOfBallsInFrame(frameIndex)
				frameIndex += 2
			}

		}
		return score
	}

	private sumOfBallsInFrame(frameIndex){
		rolls[frameIndex] + rolls[frameIndex + 1]
	}

	private spareBonus(frameIndex){
		rolls[frameIndex + 2]
	}

	private strikeBonus(frameIndex){
		rolls[frameIndex + 1] + rolls[frameIndex + 2]
	}

	private isSpare(frameIndex){
		rolls[frameIndex] + rolls[frameIndex+1] == 10
	}

	private isStrike(frameIndex){
		rolls[frameIndex] == 10
	}
}