import { Pipe, PipeTransform } from '@angular/core';

@Pipe({name: 'proficiencyString'})
export class ProficiencyStringPipe implements PipeTransform {
  transform(value: number): string {
    switch (value) {
        case 1:
            return "Apprentice";
        case 2: 
            return "Journeyman";
        case 3:
            return "Master";
        case 4:
            return "Grandmaster";
        case 5:
            return "Legend";
        case 6:
            return "Epic";
        default:
            break;
    }
  }
}