// DIVIDE AND CONQUER

/*
 * PIVOT : ek pivot element vo array ka koi bhi element ho skta hai
 * LEFT SIDE : jo elements pivot element se chote honge unhe left me rakh denge
 * RIGHT SIDE : jo elements pivot element se bde honge unhe right me rakh denge
 */

/*
 * LOW : original array ka 1st idx
 HIGH : original array ka last idx

 TWO POINTER APPRAOCH
 pivot as arr[low]

 i,j

 i = low j = high 

 abh check karenge PIVOT ELEMENT ke sath ith and jth idx value ko
 ith idx se hum phli bdi value ko dhudhenge
 jth idx se hum phli chotti value ko dhudhenge
 mil jaye toh swap

 jab i > j yani ki i cross j
 tbh stop hoajyenge aur j ki value ko swap kr denge pivot value se

 pivot value apni correct pos pr hai aur act as PARTITION ELEMENT

 */

/*
 * PARTITION ELEMENT
 * 
 * partition ho jayega array me small element on left and large element on right side
 * 
 * new array low to partition -1  &&&&  partition + 1 to high
 * 
 * repeat the above steps
 * 
 */




/*
 * TIME COMPLEXITY : O(nlogn)
 * 
 */

/*
 * SPACE COMPLEXITY : O(1)
 */




