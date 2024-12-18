import { act, render } from "@testing-library/react";
import VersionSwitcher from "./VersionSwitcher";

test('VersionSwitcher renders with no versions', () => {
    const versionSwitcher = render(<VersionSwitcher versions={[]} />);
    expect(versionSwitcher.getByText(/choose version/i)).toBeDefined();

    const allButtons = versionSwitcher.getAllByRole("button");
    expect(allButtons.length).toBe(1);

    const dropDownToggle = allButtons.filter(b => b.className.includes("dropdown-toggle"))[0];
    act(() => {
        dropDownToggle.click();
    });

    expect(versionSwitcher.getByText(/no versions available/i)).toBeDefined();
});

test('VersionSwitcher renders with one version already selected', () => {
    const versionSwitcher = render(<VersionSwitcher versions={[{ version: new Date(2023, 7), id: "1" }]} />);
    expect(versionSwitcher.getByText(/version: 2023 - 7/i)).toBeDefined();
});

test('VersionSwitcher renders with latest version already selected', () => {
    const versionSwitcher = render(<VersionSwitcher versions={[{ version: new Date(2024, 11), id: "2" }, { version: new Date(2023, 7), id: "1" }]} />);
    expect(versionSwitcher.getByText(/version: 2024 - 11/i)).toBeDefined();
    expect(versionSwitcher.queryByText(/version: 2023 - 7/i)).toBeNull();
});

test('VersionSwitcher renders new version when switching', () => {
    const versionChangedFunction = jest.fn();
    const versions = [{ version: new Date(2024, 11), id: "2" }, { version: new Date(2023, 7), id: "1" }];
    const versionSwitcher = render(<VersionSwitcher versions={versions} versionChanged={versionChangedFunction} />);

    // confirm intial state
    expect(versionSwitcher.getByText(/version: 2024 - 11/i)).toBeDefined();
    expect(versionSwitcher.queryByText(/version: 2023 - 7/i)).toBeNull();

    const allButtons = versionSwitcher.getAllByRole("button");
    expect(allButtons.length).toBe(3);

    const dropDownToggle = allButtons.filter(b => b.className.includes("dropdown-toggle"))[0];
    const secondVersionButton = allButtons.filter(b => b.textContent?.includes("2023 - 7"))[0];

    // Switch version
    act(() => {
        dropDownToggle.click();
        secondVersionButton.click();
    });

    // Version change callback have been called with the right version
    expect(versionChangedFunction).toHaveBeenCalledWith(versions[1]);

    // View changed to reflect changes
    expect(versionSwitcher.getByText(/version: 2023 - 7/i)).toBeDefined();
    expect(versionSwitcher.queryByText(/version: 2024 - 11/i)).toBeNull();
});
