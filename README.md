# hurdle-2
Rate-based analysis of ecological factors linking rinderpest seroprevalence and tree density on the Serengeti plain - accepted solution to Ph 11 2019 Hurdle 2.

See the report PDF for the full project, as well as a more detailed explanation of the programs and their context.

Code overview:
  - Main runs the fire simulator three times for each of 45 uniformly spaced grass densities, and prints the
  average percent of the grid burned. The result was used to construct Figure 6 in the Report.
  - FireSimulator represents the object that handles a fire simulation.
  - DataFormatter reads data from a copy-pasted version of that provided in Holdo et. al and prints the
  desired column in a more readily usable format.
  - Variable is a data element used by DataFormatter.
  - PopulationPrinter is essentially a script that performs a step towards aggregating the wildebeest population 
  vs time and fire frequency vs wildebeest population predictions into the fire frequency vs time prediction
  presented in the Conclusions in the Report.
