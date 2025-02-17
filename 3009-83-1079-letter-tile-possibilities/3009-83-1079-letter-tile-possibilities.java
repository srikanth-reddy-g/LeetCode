class Solution {
    public int numTilePossibilities(String tiles) {
        Set<List<Character>> hs = new HashSet<>();
        List<Character> ds = new ArrayList<>();
        int n = tiles.length();
        countTiles(0, tiles, ds, hs, n);
        return hs.size();

    }

    private void countTiles(int index, String tiles, List<Character> ds, Set<List<Character>> hs, int n) {
        if (index >= n) {
            int dsSize = ds.size();
            if (dsSize > 0) {
                hs.add(new ArrayList(ds));
                if (dsSize > 1) {
                    countTilePermutations(0, ds, hs, dsSize);
                }
            }
            return;
        }
        ds.add(tiles.charAt(index));
        countTiles(index + 1, tiles, ds, hs, n);
        ds.remove(ds.size() - 1);
        countTiles(index + 1, tiles, ds, hs, n);
    }

    private void countTilePermutations(int index, List<Character> ds, Set<List<Character>> hs, int n) {
        if (index == n) {
            hs.add(new ArrayList(ds));
            return;
        }
        for (int i = index; i < n; i++) {
            swap(i, index, ds);
            countTilePermutations(index + 1, ds, hs, n);
            swap(i, index, ds);
        }
    }

    private void swap(int i, int index, List<Character> ds) {
        Character temp = ds.get(i);
        ds.set(i, ds.get(index));
        ds.set(index, temp);
    }
}