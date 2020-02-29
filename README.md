### FIRST PLACE: AgCo Hackathon 2020: https://agcohackathon.devpost.com

## Inspiration
No one in our group has a background in agriculture. So, when we chose to work on Challenge 3: "identify the environmental factors that are considered the most critical for environmental sustainability...", we struggled to identify solutions. We ultimately came to the conclusion that we do not know, and so we shouldn't try to tell AgCo and/or farmers the best way to farm. Rather, we should create a tool that allows farmers to do what they do best: farm in the most efficient and effective ways possible, and incentivize them to make those processes more sustainable.

We discovered number of papers by Migliorini, Galioto, et al which developed an "integrated sustainability score" for agricultural processes. We chose to apply the techniques articulated in the papers to the barn data (specifically for poultry) AgCo collects.

## What it does
Farmers upload their resource consumption (using the same format as the barn data we were given), and Silo generates a sustainability score based on that. The model is based on the environmental data provided (water consumption, power consumption, temperature, etc). We then used TensorFlow to optimize the weights of different factors to generate a single score.

However, we wanted to create a platform that allows engagement beyond merely one-time information gathering. So, we developed Silo into a social platform that rewards farmers who develop more sustainable farming practices. Farmers create a profile and upload their "Layouts"--particular combinations of input parameters. Farmers can see the sustainability of other farmers' layouts, filtering by things like climate type or time of year. And finally, farmers can pay to see the layouts of some of the most sustainable/efficient farms across the country, which rewards those who come up with these ideal solutions.

In summary, Silo quantifies sustainability in agriculture, and it incentivizes sustainable behavior using The Network Effect and monetary award.

## How We built it
The app consists of an Android App, developed Java with Android Studio. The app connects to a backend written in a Python Flask server, which has been deployed onto Heroku. We use TensorFlow to optimize the relative weights in our sustainability algorithm.

## Presentation
https://docs.google.com/presentation/d/17YBfoizDINBSAz4Rg1R_h0PVAhZRj2F3b8Hi8g8TDc8/edit?usp=sharing

