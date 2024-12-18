import { render } from "@testing-library/react";
import SearchBar from "./SearchBar";

test('SearchBar renders', ()=>{
    const searchBar = render(<SearchBar />);
    expect(searchBar).toBeDefined();
});