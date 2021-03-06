import { Injectable } from '@angular/core';
import { Proficiency, BaseAttribute, CharacterSheet } from "../data/characterSheet";
// import { BASE_STATS } from "./mock-characterSheet-items";

@Injectable()
export class GameEngineService {
    //Roll dice with the classic xDy notation--e.g., 2d10 for roll 2 ten-sided
    //dice and sum the result--except with the ability to specify each dice's 
    //lower and upper bounds. For instance, perhaps each 6-sided dice should start 
    //at 0 and go up to 5.
    rollDice(numberOfDice: number, diceLowerBound: number, diceUpperBound): number {
        var diceSum = 0;
        for (var i = 0; i < numberOfDice; i++) {
            diceSum += this.randomIntFromInterval(diceLowerBound, diceUpperBound);
        }
        return diceSum;
    }
    
    //Generate a random number with a floor and max
    randomIntFromInterval(min,max): number {
        return Math.floor(Math.random()*(max-min+1)+min);
    }

    //Calculate the performance associated with a base-attribute statistic, 
    //such as speed or wisdom
    calculateStatPerformance(statValue: number): number {
        return this.rollDice(2, 1, 10) + 2 * statValue;
    }

    //Perform the calculation for skills. These require the summation of 
    // 1. a base attribute, of which there are three possibilities: coordination, wisdom, and charisma,
    // 2. the specific skill value
    // 3. a roll result based on the following:
    //     a. Apprentice proficiency: the lesser of two rolls
    //     b. Journeyman proficiency: the result of a roll
    //     c. Master proficiency: the better of two rolls
    //     d. Grandmaster proficiency: the best of three rolls...
    //     e. ...and so on as proficiency gets higher.
    // 4. Any vital modifiers, merit and status modifiers, and equipment modifiers

    calculateSkillPerformance(skillName: string, baseAttributeValue: number, skillValue: number, proficiencyValue: number): number {
        let rollResult: number = this.getRollResultBasedOnSkillProficiency(proficiencyValue);
        let skillPerformance: number = +rollResult + +baseAttributeValue + +skillValue;
        return skillPerformance;
    }

    //Get a skill's base attribute depending on what family that skill belongs to
    getSkillBaseAttribute(skillName: string): BaseAttribute {
        let skillsWithCoordinationAsABaseAttribute: string[] =[ "martial", "ranged","stealth", "athletics" ];
        let skillsWithWisdomAsABaseAttribute: string[] = [ "lore", "scouting", "crafting", "alchemy" ];
        let skillsWithCharismaAsBaseAttribute: string[] = [ "arts", "diplomacy" ];

        if (skillsWithCoordinationAsABaseAttribute.indexOf(skillName) > -1) {
            return BaseAttribute.COORDINATION;
        } else if (skillsWithWisdomAsABaseAttribute.indexOf(skillName) > -1) {
            return BaseAttribute.WISDOM;
        } else {
            return BaseAttribute.PRESENCE;
        }
    }

    //Return roll result based on proficiency
    getRollResultBasedOnSkillProficiency(proficiencyValue: number): number {
        //Lowest proficiency possible...
        if (proficiencyValue === 1) {
            return Math.min(this.rollDice(2, 1, 10), this.rollDice(2, 1, 10));
        }

        //Otherwise, build up an array of roll results based on skill proficiency,
        //keeping in mind that the Proficiency enum can be an int and that the Proficiency
        //enum is 1-indexed instead of 0-indexed
        let rollResultsArray: number[] = [];

        for (var i = 0; i < proficiencyValue - 1; i++) {
            rollResultsArray.push(this.rollDice(2, 1, 10));
        }

        //...and return the max of that array
        return Math.max.apply(null, rollResultsArray);
    }
}
