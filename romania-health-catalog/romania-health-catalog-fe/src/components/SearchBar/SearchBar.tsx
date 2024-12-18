import VersionSwitcher from "@/components/VersionSwitcher/VersionSwitcher";
import { Version } from "@/models/Version";

interface SearchBarProps{
  versions?: Version[];
}

function SearchBar({versions = []}: Readonly<SearchBarProps>) {
  return (
    <span className="container-fluid">
      <div className="row">
        <span className="col col-3">
          <VersionSwitcher versions={versions} />
        </span>
        <span className="col col-6">
          <input id="search-bar" type="search" className="form-control" placeholder="Search..." aria-label="Search" />
        </span>
        <span className="col col-3">
          <button id="search-button " className="btn btn-primary">Search</button>
        </span>
      </div>
    </span>
  );
}

export default SearchBar;