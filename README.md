# The Game

In lieu of Dungeons and Dragons, a growing group of us have been playing a rather crunchy RPG that I designed. So far, we've simply called this tabletop RPG "The Game" or, originally, "The Board Game," because we used to play it using those old cardboard tiles (along with figurines) on a tabletop.

Unfortunately, the crunchy probability and modifier mechanics of The Game have led to very, very long sessions calculating the outcomes of in-game actions. This is what led me to build a variety of apps to handle those calculations. This project is the Angular 5 (and eventually Java Spring) version of The Game.

# Installation

To demonstrate how the front-end and back-ends can be separately deployed (e.g. in their own microservices as dockerized containers, e.g. with k8s), I've separated out Angular from Sprint Boot code. With what is currently pushed to master, this app requires that CORS be turned on; this is not desirable in production; a proxy server should be used and CORS turned off.

For local deployment, deploy the Spring boot app from the back-end after a mvn clean install and ng serve the front-end app.

## Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.

## Running unit tests

Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

## Running end-to-end tests

Run `ng e2e` to execute the end-to-end tests via [Protractor](http://www.protractortest.org/).

## Further help

To get more help on the Angular CLI use `ng help` or go check out the [Angular CLI README](https://github.com/angular/angular-cli/blob/master/README.md).
