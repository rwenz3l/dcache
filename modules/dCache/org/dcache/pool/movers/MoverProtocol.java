package org.dcache.pool.movers;
import diskCacheV111.vehicles.ProtocolInfo;
import diskCacheV111.vehicles.StorageInfo;
import diskCacheV111.util.PnfsId;
import org.dcache.pool.repository.Allocator;

import org.dcache.pool.repository.RepositoryChannel;

public interface MoverProtocol
{

    /**
     * @param allocator Space allocator. May be null for a read-only
     * transfer.
     */
    public void runIO(RepositoryChannel diskFile,
                      ProtocolInfo protocol,
                      StorageInfo  storage,
                      PnfsId       pnfsId,
                      Allocator    allocator,
                      IoMode         access)
        throws Exception;

    /**
     * Get number of bytes transfered. The number of bytes may exceed
     * total file size if client does some seek requests in between.
     *
     * @return number of bytes
     */
    public long getBytesTransferred();

    /**
     * Get time between transfers begin and end. If Mover is sill
     * active, then current time used as end.
     *
     * @return transfer time in milliseconds.
     */
    public long getTransferTime();

    /**
     * Get time of last transfer.
     *
     * @return last access time in milliseconds.
     */
    public long getLastTransferred();

    /**
     * Get file modification status.
     *
     * @return true if file was changes.
     */
    public boolean wasChanged();
}
