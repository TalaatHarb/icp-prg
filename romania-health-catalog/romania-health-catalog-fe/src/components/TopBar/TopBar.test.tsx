import { render } from "@testing-library/react";
import TopBar from "./TopBar";

test('TopBar renders', ()=>{
    const topBar = render(<TopBar />);
    const title = topBar.getByText(/romania health catalog/i);
    expect(title).toBeDefined();
});