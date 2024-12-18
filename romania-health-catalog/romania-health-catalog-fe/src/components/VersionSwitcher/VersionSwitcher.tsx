import { Version } from "@/models/Version";
import { useEffect, useState } from "react";

function versionToString(v: Date): string {
    return v.getFullYear() + " - " + v.getMonth();
}

interface VersionSwitcherProps {
    /**
     * available versions in descending order
     */
    versions?: Version[];

    /**
     * Callback to call when a version changes
     */
    versionChanged?: (version: Version) => void;
}

const VersionSwitcher = ({ versions = [], versionChanged = (_) => { } }: Readonly<VersionSwitcherProps>) => {
    const [version, setVersion] = useState<Date | null>();

    useEffect(() => {
        let selectedVersion: Date | null;

        if (versions.length >= 1) {
            selectedVersion = versions[0].version;
        } else {
            selectedVersion = null;
        }

        setVersion(selectedVersion);
    }, versions);

    return (

        <div className="btn-group">
            <div className={`text-capitalize btn btn-secondary btn-lg"`}>
                {version ? "Version: " + versionToString(version) : "Choose Version"}
            </div>
            <button
                id="toggle-dropdown"
                type="button"
                className={`btn btn-secondary dropdown-toggle dropdown-toggle-split`}
                data-bs-toggle="dropdown"
                aria-expanded="false"
            >
                <span className="visually-hidden">Toggle Dropdown</span>
            </button>
            <div id="versions-menu" className="dropdown-menu">
                {versions.length >= 1 ?
                    versions.map(v => {
                        return (
                            <button id={v.id} key={v.id} className="dropdown-item" onClick={() => {
                                versionChanged(v);
                                setVersion(v.version);
                            }}>
                                {versionToString(v.version)}
                            </button>
                        );
                    })
                    : <p id="no-versions-available">No versions Available</p>}
            </div>
        </div>
    );
};
export default VersionSwitcher;