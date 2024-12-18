import { useEffect, useState } from 'react';
import TopBar from "@/components/TopBar/TopBar";
import SearchBar from "@/components/SearchBar/SearchBar";
import SearchResults from "@/components/SearchResults/SearchResults";
import DrugView from '@/components/DrugView/DrugView';
import { Version } from '@/models/Version';
import HealthCatalogService from '@/services/HealthCatalogService';
import './App.css';

function App() {

  const [versions, setVersions] = useState<Version[]>();

  // Initial loading of the application
  useEffect(() => {
    HealthCatalogService.getAvailableVersions().then(retrivedVersions => setVersions(retrivedVersions));
  }, []);

  return (
    <div className="container">
      <header className="text-center">
        <TopBar />
      </header>
      <main className="text-center">
        <SearchBar versions={versions}/>
      </main>
      <section id="results-section" className="row">
        <div className="col col-6">
          <SearchResults />
        </div>
        <div className="col col-6">
          <DrugView />
        </div>
      </section>
    </div>
  )
}

export default App;
