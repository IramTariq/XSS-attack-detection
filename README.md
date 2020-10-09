# XSS-attack-detection
In order to use this project, we have to train our model. For this purpose we have to follow these steps:
Convert the training data to numerical chromosomes using the Payload_Reader.java file.
After this, we have to separately extract features files using the Extracting_Features.java file.
These features files are converted to binary chromosomes using BooleanConversion.java file.
Redundancy within binary chromosomes files are removed using RedundancyRemoving.java file.
We get the constraint set of each feature using the gettingTargetChromosomes.java file.
Percentage of each pattern could be calculated using the PatternPercentage.java file
We have run the genetic algorithm after that to get the best and fit chromosomes separately using the GeneticAlgorithm.java file.
Median is calculated using the MaximimMinimumMean.java file.
After that Experiments are run using Experiment.java file.
We have to make sure that the paths in the source code(especially in Experiment.java) are the path where you have saved your files created in the above steps.
moreover the file to be tested should be preprocessed in the form of chromosomes first to be read by our Experiment class.
