import { render } from "@testing-library/react";
import SearchResults from "./SearchResults";

test('SearchResults renders', ()=>{
    const searchResults = render(<SearchResults />);
    expect(searchResults).toBeDefined();
});