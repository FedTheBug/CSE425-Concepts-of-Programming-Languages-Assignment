echo "******** Welcome ********"
echo ""
echo "Enter 1 to search by Year: "
echo "Enter 2 to search by State name"
echo "Enter 3 to search by Disease/Cause of death"
echo "Enter 4 to get the total number of death"
echo "Enter 5 to get the occurences of injuries"
read x
if [ $x -eq 1 ]
then
    echo "Which year you want to search?(1999-2016)"
    read Year 
    grep $Year NCHS_-_Leading_Causes_of_Death__United_States.csv
elif [ $x -eq 2 ]
then
    echo "Which state's information you are looking for? "
    read State 
    grep $State NCHS_-_Leading_Causes_of_Death__United_States.csv
elif [ $x -eq 3 ]
then
    echo "Insert the Disease/Cause of death "
    read Cause Name
    grep $Cause Name NCHS_-_Leading_Causes_of_Death__United_States.csv


elif [ $x -eq 4 ]
then
    echo "Sum of total number of deaths"
    awk -F',' '{sum+=$5} END {print sum}' NCHS_-_Leading_Causes_of_Death__United_States.csv

elif [ $x -eq 5 ]
then
    echo "Occurences of injuries per year "
    awk -F '{print $4}' | sort | uniq -c NCHS_-_Leading_Causes_of_Death__United_States.csv
else
echo "Please enter between 1 and 4"
fi
    
