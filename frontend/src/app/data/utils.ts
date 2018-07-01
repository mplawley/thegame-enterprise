import { Proficiency } from '../data/characterSheet';

export interface MapOfStringsToProficiencies {
    [details: string]: Proficiency;
}