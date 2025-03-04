class Solution {
public:
    bool checkPowersOfThree(int n) {
        int k;
        for(int i=0;i<n;i++)
        {
            if(pow(3,i)>n)
            {
                k = i-1;
                break;

            }

            else if(pow(3,i)==n)
            {
                return true;
            }
        }

        cout<<k<<" "<<endl;
     while(n && k>=0)
     {
        if(n>=pow(3,k))
        {
            n=n-pow(3,k);
            cout<<n<<" n "<<endl;
        }
        k--;
     }

       if(n==0) return true;
       return false;
        
    }
};