export enum Action {
    Movement,
    Small,
    Big,
    Round,
}

export class Power {
    powerId: number;
    powerName: string;
    powerCost: number;
    powerRange: number;
    powerAction: Action;
    powerMagnitude: number;
    powerShortDescription: string;
    powerLongDescription: string;
    powerNotes: string;
}