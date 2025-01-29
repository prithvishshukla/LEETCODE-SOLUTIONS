class Solution:
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        n=len(set(chain(*edges)))
        root=[i for i in range(n+1)]
        
        def rec(x):
            if root[x]==x:
                return x
            return rec(root[x])
        for x,y in edges:
            xr,yr=rec(x),rec(y)
            
            if xr==yr:
                return [x,y]
            elif x==xr:
                root[x]=yr
                
            elif y==yr:
                root[y]=xr
                
            else:
                root[xr]=yr