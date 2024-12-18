import { environment } from "@/environment/environment";
import { Version } from "@/models/Version";

const API_URL = `${environment.apiUrl}/backend`;
const VERSIONS_API = `${API_URL}/api/v1/versions`;

/**
 * Fetches available versions of the health catlaog from BE
 */
async function getAvailableVersions(): Promise<Version[]>{
    const data = await fetch(VERSIONS_API);
    const json = await data.json();

    return json as Version[];
}

export default {
    getAvailableVersions
};