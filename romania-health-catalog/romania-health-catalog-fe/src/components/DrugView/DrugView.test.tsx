import { render } from "@testing-library/react";
import DrugView from "./DrugView";

test('DrugView renders', ()=>{
    const drugView = render(<DrugView />);
    expect(drugView).toBeDefined();
});